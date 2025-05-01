import profile_pic from '../assets/monki.jpg';
import moment_image from '../assets/monki_moment.jpg';

function MomentCard(){
    return(
        <div className="card">
            <div className="moment-header">
                <img src={profile_pic} alt="Profile picture" className="moment-profile-pic"></img>
                <p className="moment-profile-username">funnyMonkey232</p>
            </div>
            <div className="moment-container">
                <p className="moment-likes">&#129293;9.5M</p>
                <img src={moment_image} alt="Moment image" className="moment-image"></img>
            </div>
            <p className="moment-tags">Tags: Monkey party 2025, Random chimp event, ...</p>
        </div>
    );
}

export default MomentCard;