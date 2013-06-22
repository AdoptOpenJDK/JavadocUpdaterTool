content = new File( basedir, 'build.log' ).text;

 //apidocs/index.html

assert content.contains( 'Vulnerable file found:' );