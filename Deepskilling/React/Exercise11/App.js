import React, { useState } from 'react';
import CurrencyConvertor from './Components/CurrencyConvertor';

function App() {
  const [count, setCount] = useState(5);

  const sayHello = () => {
    alert('Hello! Member1');
  };

  // "Increase" button invokes two methods: increment the value, and say hello
  const handleIncrement = () => {
    setCount(count + 1);
    sayHello();
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  // Takes "welcome" as an argument
  const sayWelcome = (message) => {
    alert(message);
  };

  // Synthetic event handler - "OnPress" equivalent using onClick
  const handlePress = (e) => {
    alert('I was clicked');
  };

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <button onClick={() => sayWelcome('welcome')}>Say welcome</button>
      <button onClick={handlePress}>Click on me</button>

      <CurrencyConvertor />
    </div>
  );
}

export default App;
