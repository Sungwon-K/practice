import React from 'react';

class Car extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      brand: "Ford",
      model: "Mustand",
      color: "red",
      year: 1964
    };
  }

  changeColor = () => {
    this.setState({color:"blue"});
  }

  render() {
    return (
      //형제(같은 레벨)태그가 있다면 div로 묶어줘야 에러가 안난다.
      <div>
        <h2>I am a {this.props.brand.name}. </h2>
        <p>
          모델명: {this.props.brand.model}!<br/>
          색상: {this.state.color}<br/>
          년식: {this.state.year}
        </p>
        <button type="button" onClick={this.changeColor}>changeColor</button>
      </div>
    );
  }
}

export default Car;