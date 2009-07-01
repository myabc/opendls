package org.opendls.search;

import org.apache.lucene.document.Document;

/**
 * A class that implements this interface provides a Lucene document.
 *
 * @author alexbcoles
 *
 */
public interface Searchable
{
 public Document getDocument();
}
