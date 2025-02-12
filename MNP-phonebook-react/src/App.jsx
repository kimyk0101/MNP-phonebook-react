import { useState, useEffect } from "react";
import PhonebookList from "./components/PhonebookList";
import PhonebookInput from "./components/PhonebookInput";

function App() {
  const apiUrl = "http://localhost:8090/api/phonebook";

  const [contacts, setContacts] = useState([]);

  const fetchContacts = async () => {
    try {
      const response = await fetch(apiUrl);
      if (!response.ok) {
        throw new Error("데이터를 받아오지 못했습니다.");
      }
      const data = await response.json();
      setContacts(data);
    } catch (error) {
      console.error("ERROR", error);
    }
  };

  useEffect(() => {
    fetchContacts();
  }, [contacts]);

  const addContact = async (name, hp, tel) => {
    const newId =
      contacts.length > 0
        ? Math.max(...contacts.map((item) => item.id)) + 1
        : 1;

    const newContactData = { id: newId, name, hp, tel };
    try {
      const response = await fetch(apiUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newContactData),
      });

      if (!response.ok) {
        throw new Error("데이터를 추가하지 못했습니다.");
      }
      fetchContacts;
    } catch (error) {
      console.error("Error adding contact:", error);
    }
  };

  const updateContact = async (id, updatedContact) => {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedContact),
      });
      if (!response.ok) {
        throw new Error("데이터를 수정하지 못했습니다.");
      }
      const updatedItem = await response.json();
      setContacts(
        contacts.map((contact) => (contact.id === id ? updatedItem : contact))
      );
    } catch (error) {
      console.error("Error updating contact:", error);
    }
  };

  const deleteContact = async (id) => {
    try {
      const response = await fetch(`${apiUrl}/${id}`, {
        method: "DELETE",
      });
      if (!response.ok) {
        throw new Error("데이터를 삭제하지 못했습니다.");
      }
      fetchContacts();
    } catch (error) {
      console.error("Error deleting contact:", error);
    }
  };

  return (
    <div>
      <PhonebookInput addContact={addContact} />
      <PhonebookList
        contacts={contacts}
        setContacts={setContacts}
        updateContact={updateContact}
        deleteContact={deleteContact}
      />
    </div>
  );
}

export default App;
