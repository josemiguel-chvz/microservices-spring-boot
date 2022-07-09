import React, { Component } from "react";
import { Modal, Button, Table } from 'react-bootstrap';

class ModalComponent extends Component {
    render() {
        return (
            <div>
                <Modal show={this.props.show} onHide={() => this.props.onHide({ msg: 'Cross Icon Clicked!' })}>
                    <Modal.Header closeButton>
                    <Modal.Title>Días Trabajados</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <h3>Empleado: <b>{this.props.data.employeeName}</b></h3>
                        <Table striped className="mt-4">
                            <thead>
                                <tr>
                                <th>Fecha</th>
                                <th>Entrada</th>
                                <th>Salida</th>
                                <th>Horas Trabajadas</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.props.data.workDays.map((day) => (
                                    <tr key={day.scheduleId}>
                                        <td>{day.date}</td>
                                        <td>{day.inHour}</td>
                                        <td>{day.outHour}</td>
                                        <td>{day.hours}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </Table>
                    </Modal.Body>
                    <Modal.Footer>
                    <Button variant="secondary" onClick={() => this.props.onClick({ msg: 'Modal Closed!' })}>
                        Cerrar
                    </Button>
                    </Modal.Footer>
                </Modal>
            </div>
        )
    }
}

export default ModalComponent;