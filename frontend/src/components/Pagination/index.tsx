import "./styles.css";
import { ReactComponent as Arrow } from "assets/arrow.svg";

const Pagination = () => (
  <div className="dsmovie-pagination-container">
    <div className="dsmovie-pagination-box">
      <button className="dsmovie-pagination-button" disabled>
        <Arrow />
      </button>
      <p>{`${1} de ${3}`}</p>
      <button className="dsmovie-pagination-button">
        <Arrow className="dsmovie-flip-horizontal" />
      </button>
    </div>
  </div>
);

export default Pagination;
