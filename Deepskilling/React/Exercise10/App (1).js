import './App.css';

const element = "Office Space";
const sr = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=600&auto=format&fit=crop";
const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;
const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };

let colors = [];
if (ItemName.Rent <= 60000) {
  colors.push('textRed');
} else {
  colors.push('textGreen');
}

// A list of office objects, looped through with map() as required by the exercise
const officeList = [
  { Name: "DBS", Rent: 50000, Address: "Chennai" },
  { Name: "TCS", Rent: 75000, Address: "Bangalore" },
  { Name: "Wipro", Rent: 45000, Address: "Hyderabad" }
];

function App() {
  return (
    <div>
      <h1>{element} , at Affordable Range </h1>
      {jsxatt}
      <h1>Name: {ItemName.Name}</h1>
      <h3 className={colors[0]}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>

      <hr />

      <h2>All Office Spaces</h2>
      {officeList.map((office, index) => {
        const rentColor = office.Rent <= 60000 ? 'textRed' : 'textGreen';
        return (
          <div key={index}>
            <h3>Name: {office.Name}</h3>
            <h4 className={rentColor}>Rent: Rs. {office.Rent}</h4>
            <p>Address: {office.Address}</p>
          </div>
        );
      })}
    </div>
  );
}

export default App;
