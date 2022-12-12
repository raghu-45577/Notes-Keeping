import axios from "axios";

const NOTES_BASE_URL = "http://localhost:8080/app/v1/notes";

class NotesService {
  getNotes() {
    return axios.get(NOTES_BASE_URL);
  }

  createNote(note) {
    return axios.post(NOTES_BASE_URL, note);
  }

  updateNote(note, id) {
    return axios.put(NOTES_BASE_URL + "/" + id, note);
  }

  deleteNote(id) {
    return axios.delete(NOTES_BASE_URL + "/" + id);
  }

  getNoteById(id) {
    return axios.get(NOTES_BASE_URL + "/" + id);
  }
}

export default new NotesService();
