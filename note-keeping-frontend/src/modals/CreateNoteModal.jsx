import React, { useState } from "react";
import Modal from "react-modal";
import NotesService from "../services/NotesService";
Modal.setAppElement("#root");

function CreateNoteModal({ created, onclick }) {
  const [note, setNote] = useState({ title: "", description: "" });
  let uid = localStorage.getItem("user");

  function inputHandler(e) {
    e.preventDefault();
    setNote({ ...note, [e.target.name]: e.target.value });
  }

  function saveHandler(e) {
    e.preventDefault();
    let id = uid.substring(0, uid.indexOf("@"));
    NotesService.createNote(note, id).then((res) => {
      console.log(id);
      onclick();
      window.location.reload();
    });
  }

  return (
    <div>
      <Modal
        isOpen={created}
        style={{
          overlay: {
            backgroundColor: "rgba(0,0,0,0.5)",
          },
          content: {
            height: "300px",
            width: "800px",
            top: "20%",
            left: "20%",
            color: "black",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-around",
            alignItems: "center",
            backgroundColor: "white",
          },
        }}
      >
        <form>
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              placeholder="Title"
              value={note.title}
              name="title"
              onChange={(e) => inputHandler(e)}
              className="form-control"
              style={{ width: "600px" }}
            />
          </div>
          <div className="form-group">
            <label>Description</label>
            <textarea
              maxLength={1000}
              value={note.description}
              name="description"
              onChange={(e) => inputHandler(e)}
              className="form-control"
              style={{ width: "600px" }}
            />
          </div>

          <div className="form-group">
            <br></br>
            <button className="btn btn-success" onClick={(e) => saveHandler(e)}>
              Save
            </button>
            <button
              className="btn btn-danger"
              style={{ marginLeft: "20px" }}
              onClick={onclick}
            >
              close
            </button>
          </div>
        </form>
      </Modal>
    </div>
  );
}

export default CreateNoteModal;
