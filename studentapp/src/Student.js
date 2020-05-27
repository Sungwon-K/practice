import React from 'react';

class Student extends React.Component {
  constructor(props) {
    super(props);
    this.state = { id: "hkd", name: "홍길동", address: "서울" };
  }
  render() {
    return (
      <div>
        <h1>Student</h1>
        <p>
          ID: {this.state.id}<br/>
          Name: {this.state.name}<br/>
          Address: {this.state.address}
        </p>
      </div>
    );
  }
}

export default Student;