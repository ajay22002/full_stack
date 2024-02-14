import React from "react";
import { AiFillThunderbolt } from "react-icons/ai";
import { BsBookFill } from "react-icons/bs";
import { FaTags } from "react-icons/fa";

import { Highlight } from "./ui";

const Highlights = () => (
  <section id="highlights" className="section">
    <div className="row">
      <h2 className="section__title">
        Why choose <span className="primary-color">Platform</span>
      </h2>
      <div className="highlight__wrapper">
        <Highlight
          icon={<AiFillThunderbolt />}
          title="Easy and Quick"
          para="Get access to the Product you purchased online instantly."
        />
        <Highlight
          icon={<BsBookFill />}
          title="10,000+ Product"
          para="Store has Product in all your favorite categories."
        />
        <Highlight
          icon={<FaTags />}
          title="Affordable"
          para="Get your hands on popular Product for as item as $10."
        />
      </div>
    </div>
  </section>
);
export default Highlights;
