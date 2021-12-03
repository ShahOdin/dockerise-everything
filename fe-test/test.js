const expect = require("chai").expect;
const request = require("request");

describe(
    'BE service', () => {

        it("1+1=2", function() {
          const two = 1 + 1;
          expect(two).to.equal(2);
        });


//        it("version endpoint should return the expected response", function(done) {
//          const url = "http://localhost:8080/version";
//          const expectedBody = {
//            "value": 1
//          }
//          request(url, function(error, response, body) {
//            expect(response.statusCode).to.equal(200);
//            expect(JSON.parse(body)).to.deep.equal(expectedBody);
//            done();
//          });
//        });

    }
)