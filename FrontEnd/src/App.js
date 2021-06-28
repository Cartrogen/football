import './App.css';
import pllogo from './images/premiere_league_logo.png';
import EnterTeam from './components/EnterTeam';



    
function App() {
  
  return (
    <div  className="App">
        <EnterTeam style={{position: "absolute"}}/>
          <div className="front-page-bottom">
           <img src={pllogo}/>
           <p> #GreatScott </p>
          </div>
    </div>
  );
}

export default App;