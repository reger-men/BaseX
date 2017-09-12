package org.basex.examples.local;

import org.basex.core.*;
import org.basex.core.cmd.*;

/**
 * This class demonstrates database creation and dropping.
 * It then shows how to add indexes to the database and retrieve
 * some information on the database structures.
 *
 * @author BaseX Team 2005-17, BSD License
 */
public final class RunCommands {
  /**
   * Runs the example code.
   * @param args (ignored) command-line arguments
   * @throws BaseXException if a database command fails
   */
  public static void example() throws BaseXException {
    // Database context.
    Context context = new Context();

    System.out.println("=== RunCommands ===");

    // Create a database from a local or remote XML document or XML String
    System.out.println("\n* Create a database.");

    //new CreateDB("DBExample", "/home/reger/Desktop/MING/BaseX/src/main/resources/xml/Users.xml").execute(context);

    // Close and reopen the database
    System.out.println("\n* Close and reopen database.");

    //new Close().execute(context);
    new Open("ADILDB").execute(context);

    // Additionally create a full-text index
    System.out.println("\n* Create a full-text index.");

    //new CreateIndex("fulltext").execute(context);
    
    // Insert a node before the closing body tag
    // N.B. do not forget to specify the namespace
    System.out.println("\n* Update the document.");

    new XQuery(
        "declare namespace xhtml='http://www.w3.org/1999/xhtml';" +
        "insert node " +
        "  <p>I will match the following query because I contain " +
        "the terms 'ARTICLE' and 'EDITABLE'. :-)</p> " +
        "into //body"
    ).execute(context);

    // Match all paragraphs' textual contents against
    // 'edit.*' AND ('article' or 'page')
    System.out.println("\n* Perform a full-text query:");	
    

    // Match all paragraphs' textual contents against
    // 'edit.*' AND ('article' or 'page')
    System.out.println("\n* Perform a full-text query:");
    
    
    
    // Show information on the currently opened database
    System.out.println("\n* Show database information:");

    System.out.print(new InfoDB().execute(context));

    // Drop indexes to save disk space
    System.out.println("\n* Drop indexes.");

    new DropIndex("text").execute(context);
    new DropIndex("attribute").execute(context);
    new DropIndex("fulltext").execute(context);

    // Drop the database
    System.out.println("\n* Drop the database.");

    new DropDB("DBExample").execute(context);

    // Show all existing databases
    System.out.println("\n* Show existing databases:");

    System.out.print(new List().execute(context));

    // Close the database context
    context.close();
  }
}