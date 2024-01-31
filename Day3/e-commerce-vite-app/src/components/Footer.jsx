import Logo from "../assets/Logo";
import { Link } from "react-router-dom";

const Footer = () => {
  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: "auto",
    });
  };

  return (
    <footer id="footer" className="section">
      <div className="row row__column">
        <Link to="/">
          {/* eslint-disable-next-line jsx-a11y/no-noninteractive-element-interactions */}
          <figure className="footer__logo" onClick={() => scrollToTop()}>
            <Logo />
          </figure>
        </Link>
        <div className="footer__list">
          <Link to="/" className="footer__link" onClick={() => scrollToTop()}>
            Home
          </Link>
          <span className="footer__link no-cursor">About</span>
          <Link
            to="/books"
            className="footer__link"
            onClick={() => scrollToTop()}
          >
            Product
          </Link>
          <Link
            to="/cart"
            className="footer__link"
            onClick={() => scrollToTop()}
          >
            Cart
          </Link>
        </div>
        <div className="footer__copyright">
          Copyright &copy; {new Date().getFullYear()} Platform
        </div>
      </div>
    </footer>
  );
};

export default Footer;
