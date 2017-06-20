package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessageAbsentSubscriber;
import org.mobicents.slee.resource.map.wrappers.MAPDialogWrapper;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.MapDialogWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPErrorWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPErrorWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMapArgsFactory;

public class TxMAPErrorWrapperTest extends WrapperBaseTest {

    TxMAPErrorWrapper mapErrorMessage;

    @Before
    public void setUp() throws Exception {

        /*TxMapArgsFactory txMapArgsFactory = new TxMapArgsFactory(mapParameterFactory);
        MAPErrorWrapper mapErrorWrapper = txMapArgsFactory.createMAPErrorWrapper();*/

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        /*
         * serializeToFile(obj); deserializeFromFile();
         * 
         * assertTrue();
         */

    }

}
