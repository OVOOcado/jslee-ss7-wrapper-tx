package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxForwardedToNumberWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMapArgsFactory;

public class TxForwardedToNumberWrapperTest extends WrapperBaseTest {

    TxForwardedToNumberWrapper txForwardedToNumberWrapper;

    @Before
    public void setUp() throws Exception {
        
        AddressString addressString = mapParameterFactory.createAddressString(AddressNature.abbreviated_number,
                NumberingPlan.land_mobile, "609283124");
        txForwardedToNumberWrapper = new TxForwardedToNumberWrapper(addressString);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txForwardedToNumberWrapper);
        TxForwardedToNumberWrapper tx = (TxForwardedToNumberWrapper) deserializeFromFile();

        assertTrue(tx.hasAddress());
        assertTrue(tx.getAddress().equals(txForwardedToNumberWrapper.getAddress()));
        assertTrue(tx.hasNature());
    }

}
