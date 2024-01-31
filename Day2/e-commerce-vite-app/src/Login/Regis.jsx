// import Link  from 'react-router-dom';
import {
    Container,
    Header,
    Content,
    Footer,
    Form,
    ButtonToolbar,
    Button,
    Navbar,
    Panel,
    FlexboxGrid
  } from 'rsuite';
  import { Link } from 'react-router-dom';
  import React from 'react';
  const Reg = () => (
    <div className="show-fake-browser login-page">
      <Container>
        <Header>
          <Navbar >
            <Navbar.Brand>
              {/* <a style={{ color:"black" }}></a> */}
            </Navbar.Brand>
          </Navbar>
        </Header>
        <Content>
          <FlexboxGrid justify="center">
            <FlexboxGrid.Item colspan={12}>
              <Panel header={<h3>User Register</h3>} bordered>
                <Form fluid>
                  <Form.Group>
                    <Form.ControlLabel>Name</Form.ControlLabel>
                    <Form.Control name="name" />
                  </Form.Group>
                  <Form.Group>
                    <Form.ControlLabel>Gmail</Form.ControlLabel>
                    <Form.Control name="gmail" />
                  </Form.Group>
                  <Form.Group>
                    <Form.ControlLabel>Password</Form.ControlLabel>
                    <Form.Control name="password" type="password" autoComplete="off" />
                  </Form.Group>
                  <Form.Group>
                    <Form.ControlLabel>ReEnter</Form.ControlLabel>
                    <Form.Control name="password" type="password" autoComplete="off" />
                  </Form.Group>
                  <Form.Group>
                    <ButtonToolbar>
                  <Button appearance="primary">Signup</Button>
                      <Button appearance="subtle">Forgot password?</Button>
                    </ButtonToolbar>
                  </Form.Group>
                  {/* <Form.ControlLabel> <Link to='/Admin'><Button appearance="primary">Admin user</Button></Link>click here</Form.ControlLabel> */}
                </Form>
              </Panel>
            </FlexboxGrid.Item>
          </FlexboxGrid>
        </Content>
        <Footer></Footer>
      </Container>
    </div>
  );
  export default Reg