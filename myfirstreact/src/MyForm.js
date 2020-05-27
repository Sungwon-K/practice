import React from 'react';
import './MyForm.css';

class MyForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { username: '' , age: null, mycar: 'Volvo'};
  }
  myChangeHandler = (event) => {
    if(event.target.name === "age"){
    if(!Number(event.target.value)){
      alert("숫자를 입력하세요");
      event.target.value="";//초기화
      return;//함수종료
    }
  }
    
    this.setState({ [event.target.name]: event.target.value });
  }
  render() {
    return (
      <form>
        <h1>Hello {this.state.username} {this.state.age} </h1>
        <p>Enter your name:</p>
        <input
          type='text'
          name="username"
          onChange={this.myChangeHandler}
        />
        
        <p>Enter your age:</p>
        <input
          type='text'
          name='age'
          onChange={this.myChangeHandler}
        />
        
        <br />
        <select value = {this.state.mycar}>
          <option value="Ford">Ford</option>
          <option value="Volvo">Volvo</option>
          <option value="Fiat">Fiat</option>
        </select>
      </form>
    );
  }
}

export default MyForm;