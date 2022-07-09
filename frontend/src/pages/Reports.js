import { Container, Row, Col, Table, Button} from "react-bootstrap";
import { useEffect, useState } from "react";
import ModalComponent from "../components/ModalComponent";
import axios from "axios";

const BASE_URL = 'http://localhost:8080/report'

const Reports = () => {
    const [reports, setReports] = useState([]);
    const fetchReports = async () => {
        const response = await axios.get(BASE_URL);
        setReports(response.data)
    };

    useEffect(() => {
        fetchReports();
    }, []);

    const [show, setShow] = useState(false);
    const [modalData, setModalData] = useState({})

    const handleClose = () => setShow(false);
    const handleShow = (employee, e) => {
        setShow(true);
        setModalData(employee);
    }


    return (
        <Container style={{display: 'flex', justifyContent: 'center', marginTop: '70px'}}>
            <Row>
                <Col lg="12">
                    <h1>Lista de reportes</h1>
                </Col>
                <Col lg="12">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Categoria</th>
                            <th>Dias Trabajados</th>
                            </tr>
                        </thead>
                        <tbody>
                            {reports.map((report) => (
                                <tr key={report.employeeId} >
                                    <td>{report.employeeId}</td>
                                    <td>{report.employeeName}</td>
                                    <td>{report.employeeCategory}</td>
                                    <td>
                                    <Button variant="primary" onClick={(e) => handleShow(report, e)}>
                                        Ver días trabajados
                                    </Button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
            {show &&
                <ModalComponent
                    show={show}
                    onHide={handleClose}
                    onClick={handleClose}
                    data={modalData}
                />
            }
        </Container>
    )
}

export default Reports;