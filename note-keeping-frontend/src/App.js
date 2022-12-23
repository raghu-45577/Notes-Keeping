import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import LoginPage from "./components/LoginPage";
import NotesList from "./components/NotesList";
import CreateNoteModal from "./modals/CreateNoteModal";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route
          path="/notes"
          element={[
            <NotesList key={3} />,
            <Header key={1} />,
            <Footer key={2} />,
          ]}
        />
        <Route path="/newNote" element={<CreateNoteModal />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
