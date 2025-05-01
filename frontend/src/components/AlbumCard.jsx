import MomentCard  from './MomentCard'

function AlbumCard(){
    return (
        <div className="album-card">
            <p className="album-name">Cool album name</p>
            <hr></hr>
            <div className="album-preview">
                <MomentCard/>
                <MomentCard/>
                <div className="album-check-more">
                    <p>Check more moments from this album</p>
                    <p>...</p>
                </div>  
            </div>
        </div>
    );
}

export default AlbumCard;