import React from 'react'
import { useState } from 'react'
import { useHistory } from 'react-router-dom';

const EnterTeam = () => {

    const [teamName, setTeamName] = useState("")
    const history = useHistory();      

    const onSubmit = () => {
        // e.preventDefault();
        console.log("Submit button clicked");

        if (!teamName) {
            return
        }

        history.push(`/team/${teamName}`)
    }

    return (
        <form onSubmit={onSubmit}>
        <div className="form-control">
            <input style={{padding: "8px", height: "30px", borderRadius: "10px", fontSize:"20px", border:"2px solid black", outline: "none"}} autoFocus size = "60" type="text" placeholder="Team Name" required="Required" onChange={(e) => setTeamName(e.target.value)}></input>
            <input type="submit" value="Shoot" className="submit-btn" data={{teamName}}/>
        </div>
        </form>
    )
}


export default EnterTeam