import React from 'react';
import '../css/GameUtils.css';
import profileImg from '../images/stick-head.png';
import statistics from '../images/statistics.png'
const GameUtils = () => {
    return(
        <div className="links-jogo disabled">
            <div className="profile">
                <img src={profileImg} alt="Link perfil"/>
                <p>Perfil</p>
            </div>
            <div className="statistics">
                <img src={statistics} alt="Link estatísticas"/>
                <p>Estatísticas</p>
            </div>
            <div className="info"></div>
        </div>
    );
}

export default GameUtils;
