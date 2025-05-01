import profile_pic from '../assets/monki.jpg';
import MomentCard  from './MomentCard'

function ProfilePage(){
    return(
        <div className="profile-page">
            <div className="profile-header">
                <img src={profile_pic} alt="Profile picture" className="profile-pic"></img>
                <p className="profile-username">funnyMonkey232</p>
            </div>
            <p className="profile-bio">Wise monki once said "banana good, but 2 banana even better"</p>
            <div className='profile-stats'>
                <p className="profile-stat">Following: 132</p>
                <p className="profile-stat">Followers: 5.3M</p>
            </div>
            <button className="follow-button">Follow</button>
            <div className='content-filter'>
                <button className="content-filter-button">Sort by albums</button>
                <button className="content-filter-button">Sort by moments</button>
            </div>
            <div></div>
            <div className="profile-content-moments">
                <p className="year-identifier">2025</p> 
                <div className="year-profile-moments">
                    <MomentCard/>
                    <MomentCard/>
                    <MomentCard/>
                </div>
            </div>
            <div className="profile-content-albums">
                <p className="year-identifier">2024</p>
                <div className="year-profile-albums">
                    <div></div>
                </div>
            </div>
        </div>
    );
}

export default ProfilePage;
