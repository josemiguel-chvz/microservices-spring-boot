import './App.css';
import { Container } from 'react-bootstrap';
import { Routes, Route } from "react-router-dom";
import Layout from "./layouts/Layout";
import Employees from "./pages/Employees";
import Reports from "./pages/Reports";


function App() {
  return (
    <Layout>
      <Container>
        <Routes>
          <Route path="/" element={<Employees />} exact />
          <Route path="/reports" element={<Reports />} exact/>
        </Routes>
      </Container>
    </Layout>
  );
}

export default App;
