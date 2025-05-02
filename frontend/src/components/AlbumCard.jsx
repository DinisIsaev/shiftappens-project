import MomentCard  from './MomentCard'
import ProfilePicTest from '../assets/monki.jpg'

function AlbumCard(){
    return (
        <div className="album-card">
            <p className="album-name">Cool album name</p>
            <div className="album-preview">
                <MomentCard/>
                <MomentCard/>
                <MomentCard/>
                <div className="album-check-more">
                    <p>Check more moments from this album</p>
                    <p>...</p>
                </div>  
            </div>
            <div className="album-associated-area">
                <p className="album-associated-text">Associated:</p>
                <img src={ProfilePicTest} className="album-associated-profile-pic"></img>
                <img src={ProfilePicTest} className="album-associated-profile-pic"></img>
                <img src={ProfilePicTest} className="album-associated-profile-pic"></img>
            </div>
        </div>
    );
}

export default AlbumCard;