import React, { useEffect, useState } from "react";
import Modal from "react-modal";
import NotesService from "../services/NotesService";
Modal.setAppElement("#root");

function ViewNoteModal({ view, onclick, nid }) {
  const [note, setNote] = useState({ title: "", description: "" });

  useEffect(() => {
    NotesService.getNoteById(nid).then((res) => {
      setNote(res.data);
    });
    console.log(nid);
  }, [nid]);

  return (
    <div>
      <Modal
        isOpen={view}
        style={{
          overlay: {
            backgroundColor: "rgba(0,0,0,0.5)",
          },
          content: {
            height: "500px",
            width: "500px",
            top: "5%",
            left: "30%",
            color: "black",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            backgroundColor: "white",
          },
        }}
      >
        <div>
          <h3>{note.title}</h3>
        </div>
        <div
          className="scroll"
          style={{
            width: "80%",
            height: "70%",
            overflowWrap: "break-word",
            marginTop: "30px",
            overflowY: "scroll",
          }}
        >
          <p>{note.description}</p>
        </div>
        <button
          className="btn btn-danger"
          style={{ marginTop: "60px" }}
          onClick={onclick}
        >
          close
        </button>
      </Modal>
    </div>
  );
}

export default ViewNoteModal;
