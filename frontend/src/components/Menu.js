import { Nav,Navbar, Container, NavDropdown } from "react-bootstrap";
const Menu = () => {
    return (
        <Navbar bg="dark" variant="dark" fixed='top'>
            <Container>
            <Navbar.Brand href="/">App Reportes</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="me-auto">
                    <Nav.Link href="/">Empleados</Nav.Link>
                    <Nav.Link href="/reports">Reportes</Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}

export default Menu;