import "./styles.css";
import { ReactComponent as GithubIcon } from "assets/octupus.svg";

const Navbar = () => (
  <header>
    <nav className="container">
      <div className="dsmovie-nav-content">
        <h1>DSMovie</h1>
        <a
          href="https://github.com/EduardoPazz"
          target="_blank"
          rel="noreferrer"
        >
          <div className="dsmovie-contact-container">
            <GithubIcon />
            <p className="dsmovie-contact-link">/EduardoPazz</p>
          </div>
        </a>
      </div>
    </nav>
  </header>
);

export default Navbar;
