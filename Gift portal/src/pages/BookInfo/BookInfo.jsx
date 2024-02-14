import "./BookInfo.css";
import { Link, useParams, useNavigate } from "react-router-dom";
import { HiArrowLeft } from "react-icons/hi";
import { Rating, Price, Book } from "../../components/ui";

// https://reactrouter.com/en/main/hooks/use-params
// useParams() hook returns an object of dynamic params from current URL

const BookInfo = ({ props }) => {
  const { books, addToCart, cart } = props;

  const { id } = useParams(); // return an object(key/value)
  const navigate = useNavigate();
  // console.log(id);
  const book = books.find((book) => book.id === +id); // + convert str to number
  // console.log(book);

  function addBookToCart(book) {
    addToCart(book);
  }

  function bookExistOnCart() {
    // The find() method returns undefined if no elements are found.
    return cart.find((book) => book.id === +id);
  }

  return (
    <main id="books__main">
      <div className="books__container">
        <div className="row">
          <header className="book__selected--top">
            <button onClick={() => navigate(-1)} className="book__link">
              <HiArrowLeft />
            </button>
            <Link to="/books" className="book__link">
              <h3 className="book__selected--title--top">Product</h3>
            </Link>
          </header>
          <article className="book__selected">
            <figure className="book__selected--figure">
              <img src={book.url} alt="" className="book__selected--img" />
            </figure>
            <div className="book__selected--description">
              <h2 className="book__selected--title">{book.title}</h2>
              <Rating rating={book.rating} />
              <h4 className="book__price">
                <Price
                  salePrice={book.salePrice}
                  originalPrice={book.originalPrice}
                />
              </h4>
              <div className="book__summary">
                {/* <h4 className="book__summary--title">Summary</h4> */}
                <p className="book__summary--para">
                  {/* Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Obcaecati, libero quae! Laudantium tenetur adipisci odio alias
                  quia, obcaecati deleniti labore, dignissimos accusamus totam
                  consequuntur earum magnam quisquam voluptas fuga sint. */}
                </p>
              </div>
              {bookExistOnCart() ? (
                <Link to={`/cart`} className="book__link">
                  <button className="btn btn-orange">Checkout</button>
                </Link>
              ) : (
                <button
                  onClick={() => addBookToCart(book)}
                  className="btn btn--yellow "
                >
                  Add to cart
                </button>
              )}
            </div>
          </article>
        </div>
      </div>

      <div className="books__container">
        <div className="row">
          <div className="book__selected--top">
            <h3 className="book__selected--title--top">Recommended Product</h3>
          </div>
          <div className="books">
            {books
              .filter((book) => book.rating === 5 && book.id !== +id) // + convert str to number
              .slice(0, 4)
              .map((book) => (
                <Book book={book} key={book.id} />
              ))}
          </div>
        </div>
      </div>
    </main>
  );
};

export default BookInfo;
