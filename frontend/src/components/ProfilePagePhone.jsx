import profile_pic from '../assets/monki.jpg';
import blacklogo from '../assets/blackmomentz.png'
import MomentCard  from './MomentCard'
import SortByAlbumsPart from './SortByAlbumsPart';

function ProfilePage(){
    return(
        <div className="profile-page">
            <img src={blacklogo} className='profile-logo'></img>
            <div className='profile-header'>
                <img src={profile_pic} alt="Profile picture" className="profile-pic"></img>
                <div className="profile-infos">
                    <p className="profile-username">funnyMonkey232</p>
                    <p className="profile-bio">Monkey see, monkey do</p>
                    <div className='profile-stat-part'>
                        <p className="profile-stat">1.2K&nbsp;</p>
                        <p className='profile-smalltext'>Friends</p>
                    </div>
                </div>
            </div>
            <button className="follow-button">Send friend request</button>
            <p className="profile-text">Sort by</p>
            <div className='content-filter-buttons'>
                <button className="content-filter-button">Albums</button>
                <button className="content-filter-button">Moments</button>
            </div>
            <div className='profile-content'>
                <SortByAlbumsPart/>
                <SortByAlbumsPart/>
            </div>
        </div>
    );
}

export default ProfilePage;
