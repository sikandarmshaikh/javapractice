package codility.interview.programs;

/*
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional; */ 


class ProductionLineTester {

  /* private final ProductVerifier verifier;

  ProductionLineTester(ProductVerifier verifier) {
    this.verifier = verifier;
  }

  ProductLineTestReport test(Stream<Product> products) {

        //long count =  products.skip(10).limit(20).filter(x -> x == null).count();
        long count =  products.skip(10).limit(20).filter(x -> x == null).count();
        if(count == 0)
          return new ProductLineTestReport(0,0,0,0);
        //System.out.println(count);
        List<Product> productsList = products.skip(10).limit(20).filter(x -> x != null).filter(p ->  
    p.getStatus().equalsIgnoreCase("invalid")).collect(Collectors.toList()); 
    
    long correctCnt = 0, checkedExcCnt = 0, uncheckedExcCnt = 0, otherExcCnt = 0; 
    for (Product product : productsList) {
         
       try{
        verifier.verify(product);
        correctCnt = correctCnt+1;
       } catch (Error e) {
			      otherExcCnt++;            
	    	} catch(RuntimeException re) {
			      uncheckedExcCnt++;
		    } catch(Exception e) {
		    	checkedExcCnt++;
		    } 
		}
    ProductLineTestReport report = new ProductLineTestReport(correctCnt,checkedExcCnt,uncheckedExcCnt,otherExcCnt);
      if(report == null){
          return new ProductLineTestReport(0,0,0,0);
       }

    return report;
  }
*/
}

