import { Container, Row, Col, Table } from "react-bootstrap";
import { useEffect, useState } from "react";
import axios from "axios";

const BASE_URL = 'http://localhost:8080/employee'
const Employees = () => {
    const [employees, setEmployees] = useState([]);

    const fetchEmployees = async () => {
        const response = await axios.get(BASE_URL);
        setEmployees(response.data)
    };

    useEffect(() => {
        fetchEmployees();
    }, []);

    return (
        <Container style={{display: 'flex', justifyContent: 'center', marginTop: '70px'}}>
            <Row>
                <Col lg="12">
                    <h1>Lista de empleados</h1>
                </Col>
                <Col lg="12">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Categoria</th>
                            </tr>
                        </thead>
                        <tbody>
                            {employees.map((employee) => (
                                <tr key={employee.id}>
                                    <td>{employee.id}</td>
                                    <td>{employee.name}</td>
                                    <td>{employee.category}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>
    )
}

export default Employees;