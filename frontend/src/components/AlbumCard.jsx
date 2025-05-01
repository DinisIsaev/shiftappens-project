import MomentCard  from './MomentCard'

function AlbumCard(){
    return (
        <div className="album-card">
            <p className="album-name">Cool album name</p>
            <div className="album-preview">
                <MomentCard/>
                <MomentCard/>
                <div className="album-check-more">
                    
                    <p className="moment-tags">Check more moments from this album</p>
                </div>
            </div>
        </div>
    );
}

export default AlbumCard;