import React from 'react'
import { useState, useEffect } from 'react'
import arsenalLogo from '../images/Arsenal.png';
import liverpoolLogo from '../images/Liverpool.png';
import chelseaLogo from '../images/Chelsea.png';
import manchester_unitedLogo from '../images/manchester_united.png';
import manchester_cityLogo from '../images/manchester_city.png';
import tottenhamlogo from '../images/Tottenham.png';
import liecesterLogo from '../images/Liecester.png';
import crystal_palaceLogo from '../images/crystal_palace.png';
import evertonLogo from '../images/Everton.png';
import burnleyLogo from '../images/Burnley.png';
import SouthamptonLogo from '../images/Southampton.png';
import bournemouthLogo from '../images/Bournemouth.png';
import west_hamLogo from '../images/west_ham.png';
import watfordLogo from '../images/Watford.png';
import newcastleLogo from '../images/Newcastle.png';
import cardiffLogo from '../images/Cardiff.png';
import fulhamLogo from '../images/Fulham.png';
import brighton_albionLogo from '../images/brighton_albion.png';
import huddersfieldLogo from '../images/Huddersfield.png';
import wolvesLogo from '../images/Wolves.png';


const TeamData = (data) => {

    const [teamData, setTeamData] = useState("")
    const [teamLogo, setTeamLogo] = useState("")

    useEffect(() => {

        let reqBody = {team: data.match.params.teamName}
            getTeamData(reqBody)  
            console.log("Request to API = " + JSON.stringify(reqBody));
      
        }, [teamLogo])

        const getTeamData = async (request) => {
            let response = {}
            try {
            const res = await fetch("http://localhost:8080/team/getTeam", {
                method: "POST", 
                headers: {
                    "Content-type": 'application/JSON' 
                },
                body: JSON.stringify(request)    
            })
    
            const response =  await res.json()
            if (response.errorCode >= 400) {
                throw new Error(response.errorMessage);
            }
            console.log("Response from API = " + JSON.stringify(response));
            setTeamData(response);
            let logo = determineTeamLogo()
            setTeamLogo(logo)
            console.log(teamLogo);
        }
        catch(err) {
            console.log(err);
        }
         
            return response;
        }

        const determineTeamLogo = () => {
            let logo;
            switch (teamData.commonName) {
                case("Arsenal") :
                return arsenalLogo;
                case("AFC Bournemouth") :
                return bournemouthLogo
                case("Brighton & Hove Albion") :
                return brighton_albionLogo
                case("Burnley") :
                return burnleyLogo
                case("Cardiff City") :
                return cardiffLogo
                case("Chelsea") : 
                return chelseaLogo
                case("Crystal Palace") :
                return crystal_palaceLogo
                case("Everton") :
                return evertonLogo
                case("Fulham") :
                return fulhamLogo
                case("Huddersfield Town") :
                return huddersfieldLogo
                case("Liecester City") :
                return liecesterLogo
                case("Liverpool") :
                return liverpoolLogo;
                case("Manchester City") :
                return manchester_cityLogo
                case("Manchester United") :
                return manchester_unitedLogo
                case("Newcastle United") :
                return newcastleLogo
                case("Southampton") :
                return SouthamptonLogo
                case("Tottenham Hotspur") :
                return tottenhamlogo
                case("Watford") :
                return watfordLogo
                case("West Ham United") :
                return west_hamLogo
                case("Wolverhampton Wanderers") :
                return wolvesLogo
            }

        }
    

    return (


        <body >
            <div className="flex-top-container">
                <div> 
                    <img src={teamLogo} style={{maxHeight:136, maxWidth:136, marginTop:57, marginLeft:55}}></img>
                </div>
                <div className="flex-teamInfo-container"> 
                    <div style={{fontSize:64, color:'white', fontWeight:'bold'}}>{teamData?.teamName}</div>
                    <div style={{fontSize:18}}>{teamData?.season}</div>
                    <div style={{fontSize:18}}> Country: {teamData?.country}</div>
                </div>
                <div className='flex-break'></div>
                <div className="flex-teamPosition-container">
                    <div style={{fontSize:64}}>{teamData?.leaguePosition}</div>
                    <div style={{fontSize:30, marginTop:10}}>League Position</div>
                </div>


            </div>
        </body>
    )

}

export default TeamData
