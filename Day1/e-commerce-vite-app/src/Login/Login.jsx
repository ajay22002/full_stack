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
  const Login = () => (
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
              <Panel header={<h3>Login</h3>} bordered>
                <Form fluid>
                  <Form.Group>
                    <Form.ControlLabel>Username or email address</Form.ControlLabel>
                    <Form.Control name="name" />
                  </Form.Group>
                  <Form.Group>
                    <Form.ControlLabel>Password</Form.ControlLabel>
                    <Form.Control name="password" type="password" autoComplete="off" />
                  </Form.Group>
                  <Form.Group>
                    <ButtonToolbar>
                  <Button appearance="primary">Login</Button>
                      <Button appearance="subtle">Forgot password?</Button>
                    </ButtonToolbar>
                  </Form.Group>
                  <Form.ControlLabel>New user <Link to='/register'><Button appearance="primary">SignUp</Button></Link> here</Form.ControlLabel>
                </Form>
                <Form.ControlLabel>click here <Link to='/Admin'><Button appearance="primary">Admin user</Button></Link></Form.ControlLabel>
              </Panel>
            </FlexboxGrid.Item>
          </FlexboxGrid>
        </Content>
        <Footer></Footer>
      </Container>
    </div>
  );
  export default Login