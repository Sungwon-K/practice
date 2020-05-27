import React from 'react';
import Car from './Car.js';

class Garage extends React.Component {
    render() {
        const carinfo = {name: "Ford", model: "Mustang"};

        return (
            <div>
                <h1>Who lives in my garage?</h1>
                <Car brand={carinfo} />
            </div>
        );
    }
}

export default Garage;