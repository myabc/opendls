package org.opendls.publicclient.tiles;

import org.opendls.model.Collection;
import org.opendls.service.CollectionService;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparerSupport;

/**
 * <code>ViewPreparer</code> for the functions block tile, that includes a
 * list of all visible Collections within the System.
 *
 * @author alexbcoles
 *
 */
public class FunctionsTileController extends ViewPreparerSupport
{
    CollectionService collectionService;

    public void setCollectionService(CollectionService collectionService)
    {
        this.collectionService = collectionService;
    }

    @Override
    public void execute(TilesRequestContext tilesContext,
            AttributeContext attributeContext) throws PreparerException
    {
//        CollectionService collectionService = (CollectionService)  getApplicationContext()
//                .getBean("collectionService");

        List<Collection> collections = collectionService
                .findVisibleCollections();
        attributeContext.putAttribute("collections", new Attribute(collections));
    }

}
