(() => {
var exports = {};
exports.id = 888;
exports.ids = [888];
exports.modules = {

/***/ 188:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  "default": () => (/* binding */ _app)
});

// EXTERNAL MODULE: external "react"
var external_react_ = __webpack_require__(297);
// EXTERNAL MODULE: ./node_modules/next/image.js
var next_image = __webpack_require__(675);
// EXTERNAL MODULE: ./node_modules/next/link.js
var next_link = __webpack_require__(664);
;// CONCATENATED MODULE: external "next/router"
const router_namespaceObject = require("next/router");
// EXTERNAL MODULE: external "reactstrap"
var external_reactstrap_ = __webpack_require__(99);
;// CONCATENATED MODULE: ./assets/images/logos/white-text.png
/* harmony default export */ const white_text = ({"src":"/_next/static/image/assets/images/logos/white-text.77407cf72d255b253bcb0b8e4b601701.png","height":60,"width":169,"blurDataURL":"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAADCAMAAACZFr56AAAAHlBMVEX/+/r///////////9MaXH/////////oIP+oYX/7+rMZsmbAAAACnRSTlNOHFwtABTQaZhwCGspkQAAAAlwSFlzAAALEwAACxMBAJqcGAAAACFJREFUCJkFwYcBACAMwzBntMD/DyORTNt72MXwwJYizQcE3QBOYKV6RwAAAABJRU5ErkJggg=="});
// EXTERNAL MODULE: external "react/jsx-runtime"
var jsx_runtime_ = __webpack_require__(282);
;// CONCATENATED MODULE: ./layout/header/Header.js









const Header = () => {
  const {
    0: isOpen,
    1: setIsOpen
  } = (0,external_react_.useState)(false);
  const router = (0,router_namespaceObject.useRouter)();

  const toggle = () => setIsOpen(!isOpen);

  return /*#__PURE__*/jsx_runtime_.jsx("div", {
    className: "topbar",
    id: "top",
    children: /*#__PURE__*/jsx_runtime_.jsx("div", {
      className: "header6",
      children: /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.Container, {
        className: "po-relative",
        children: /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Navbar, {
          className: "navbar-expand-lg h6-nav-bar",
          children: [/*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.NavbarBrand, {
            href: "/",
            children: /*#__PURE__*/jsx_runtime_.jsx(next_image.default, {
              src: white_text,
              alt: "wrapkit"
            })
          }), /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.NavbarToggler, {
            onClick: toggle,
            children: /*#__PURE__*/jsx_runtime_.jsx("span", {
              className: "ti-menu"
            })
          }), /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Collapse, {
            isOpen: isOpen,
            navbar: true,
            className: "hover-dropdown ml-auto",
            id: "h6-info",
            children: [/*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Nav, {
              navbar: true,
              className: "ml-auto",
              children: [/*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.NavItem, {
                children: /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "/",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: router.pathname == "/" ? "text-white nav-link" : "nav-link",
                    children: "Custom Components"
                  })
                })
              }), /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.NavItem, {
                children: /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "/basic",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: router.pathname == "/basic" ? "text-white nav-link" : "nav-link",
                    children: "Basic-Components"
                  })
                })
              })]
            }), /*#__PURE__*/jsx_runtime_.jsx("div", {
              className: "act-buttons",
              children: /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.NavLink, {
                href: "https://wrappixel.com/templates/nextkit-nextjs-free-uikit",
                className: "btn btn-light font-14",
                target: "_blank",
                children: "Download Free"
              })
            })]
          })]
        })
      })
    })
  });
};

/* harmony default export */ const header_Header = (Header);
;// CONCATENATED MODULE: ./layout/footer/Footer.js
/* eslint-disable */






const Footer = () => {
  return /*#__PURE__*/jsx_runtime_.jsx("div", {
    className: "footer4 b-t spacer",
    children: /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Container, {
      children: [/*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Row, {
        children: [/*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Col, {
          lg: "3",
          md: "6",
          className: "m-b-30",
          children: [/*#__PURE__*/jsx_runtime_.jsx("h5", {
            className: "m-b-20",
            children: "Address"
          }), /*#__PURE__*/jsx_runtime_.jsx("p", {
            children: "71 Amsteroum Avenue Cronish Night, NY 35098"
          })]
        }), /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Col, {
          lg: "3",
          md: "6",
          className: "m-b-30",
          children: [/*#__PURE__*/jsx_runtime_.jsx("h5", {
            className: "m-b-20",
            children: "Phone"
          }), /*#__PURE__*/(0,jsx_runtime_.jsxs)("p", {
            children: ["Reception : +205 123 4567 ", /*#__PURE__*/jsx_runtime_.jsx("br", {}), "Office : +207 235 7890"]
          })]
        }), /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Col, {
          lg: "3",
          md: "6",
          className: "m-b-30",
          children: [/*#__PURE__*/jsx_runtime_.jsx("h5", {
            className: "m-b-20",
            children: "Email"
          }), /*#__PURE__*/(0,jsx_runtime_.jsxs)("p", {
            children: ["Office :", /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: "info@wrappixel.com"
              })
            }), /*#__PURE__*/jsx_runtime_.jsx("br", {}), "Site :", /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "https://www.wrappixel.com",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: "wrappixel.com"
              })
            })]
          })]
        }), /*#__PURE__*/(0,jsx_runtime_.jsxs)(external_reactstrap_.Col, {
          lg: "3",
          md: "6",
          children: [/*#__PURE__*/jsx_runtime_.jsx("h5", {
            className: "m-b-20",
            children: "Social"
          }), /*#__PURE__*/(0,jsx_runtime_.jsxs)("div", {
            className: "round-social light",
            children: [/*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: /*#__PURE__*/jsx_runtime_.jsx("i", {
                  className: "fa fa-facebook"
                })
              })
            }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: /*#__PURE__*/jsx_runtime_.jsx("i", {
                  className: "fa fa-twitter"
                })
              })
            }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: /*#__PURE__*/jsx_runtime_.jsx("i", {
                  className: "fa fa-google-plus"
                })
              })
            }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: /*#__PURE__*/jsx_runtime_.jsx("i", {
                  className: "fa fa-youtube-play"
                })
              })
            }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
              href: "#",
              children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                className: "link",
                children: /*#__PURE__*/jsx_runtime_.jsx("i", {
                  className: "fa fa-instagram"
                })
              })
            })]
          })]
        })]
      }), /*#__PURE__*/jsx_runtime_.jsx("div", {
        className: "f4-bottom-bar",
        children: /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.Row, {
          children: /*#__PURE__*/jsx_runtime_.jsx(external_reactstrap_.Col, {
            md: "12",
            children: /*#__PURE__*/(0,jsx_runtime_.jsxs)("div", {
              className: "d-flex font-14",
              children: [/*#__PURE__*/(0,jsx_runtime_.jsxs)("div", {
                className: "m-t-10 m-b-10 copyright",
                children: ["All Rights Reserved by", " ", /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "https://www.wrappixel.com",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: "link",
                    children: "wrappixel.com"
                  })
                })]
              }), /*#__PURE__*/(0,jsx_runtime_.jsxs)("div", {
                className: "links ml-auto m-t-10 m-b-10",
                children: [/*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "#",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: "p-10 p-l-0",
                    children: "Terms of Use"
                  })
                }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "#",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: "p-10",
                    children: "Legal Disclaimer"
                  })
                }), /*#__PURE__*/jsx_runtime_.jsx(next_link.default, {
                  href: "#",
                  children: /*#__PURE__*/jsx_runtime_.jsx("a", {
                    className: "p-10",
                    children: "Privacy Policy"
                  })
                })]
              })]
            })
          })
        })
      })]
    })
  });
};

/* harmony default export */ const footer_Footer = (Footer);
;// CONCATENATED MODULE: ./layout/Layout.js





const Layout = ({
  children
}) => {
  return /*#__PURE__*/(0,jsx_runtime_.jsxs)("div", {
    id: "main-wrapper",
    children: [/*#__PURE__*/jsx_runtime_.jsx(header_Header, {}), /*#__PURE__*/jsx_runtime_.jsx("div", {
      className: "page-wrapper",
      children: /*#__PURE__*/jsx_runtime_.jsx("div", {
        className: "container-fluid",
        children: children
      })
    }), /*#__PURE__*/jsx_runtime_.jsx(footer_Footer, {})]
  });
};

/* harmony default export */ const layout_Layout = (Layout);
;// CONCATENATED MODULE: ./pages/_app.js
function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) { symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); } keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { _defineProperty(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }





function MyApp({
  Component,
  pageProps
}) {
  return /*#__PURE__*/jsx_runtime_.jsx(layout_Layout, {
    children: /*#__PURE__*/jsx_runtime_.jsx(Component, _objectSpread({}, pageProps))
  });
}

/* harmony default export */ const _app = (MyApp);

/***/ }),

/***/ 325:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/server/denormalize-page-path.js");

/***/ }),

/***/ 822:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/server/image-config.js");

/***/ }),

/***/ 695:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/head.js");

/***/ }),

/***/ 378:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/i18n/normalize-locale-path.js");

/***/ }),

/***/ 162:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/mitt.js");

/***/ }),

/***/ 773:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router-context.js");

/***/ }),

/***/ 248:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/get-asset-path-from-route.js");

/***/ }),

/***/ 372:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/is-dynamic.js");

/***/ }),

/***/ 665:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/parse-relative-url.js");

/***/ }),

/***/ 747:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/querystring.js");

/***/ }),

/***/ 333:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/route-matcher.js");

/***/ }),

/***/ 456:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/router/utils/route-regex.js");

/***/ }),

/***/ 556:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/to-base-64.js");

/***/ }),

/***/ 620:
/***/ ((module) => {

"use strict";
module.exports = require("next/dist/shared/lib/utils.js");

/***/ }),

/***/ 297:
/***/ ((module) => {

"use strict";
module.exports = require("react");

/***/ }),

/***/ 282:
/***/ ((module) => {

"use strict";
module.exports = require("react/jsx-runtime");

/***/ }),

/***/ 99:
/***/ ((module) => {

"use strict";
module.exports = require("reactstrap");

/***/ }),

/***/ 431:
/***/ (() => {

/* (ignored) */

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../webpack-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = __webpack_require__.X(0, [426,664,675], () => (__webpack_exec__(188)));
module.exports = __webpack_exports__;

})();