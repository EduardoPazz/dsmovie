import "./styles.css";
import { ReactComponent as StarFull } from "assets/star-full.svg";
import { ReactComponent as StarHalf } from "assets/star-half.svg";
import { ReactComponent as StarEmpty } from "assets/star-empty.svg";

const MovieStars = () => (
  <div className="dsmovie-stars-container">
    <StarFull />
    <StarFull />
    <StarFull />
    <StarHalf />
    <StarEmpty />
  </div>
);

export default MovieStars;
