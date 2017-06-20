package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSubscriberIdentityWrapper;

public class TxMAPSubscriberIdentityWrapperTest extends WrapperBaseTest {

    TxMAPSubscriberIdentityWrapper txMAPSubscriberIdentityWrapper;

    @Before
    public void setUp() throws Exception {

        ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.national_significant_number, NumberingPlan.national, "0048752987354");
        SubscriberIdentity subscriberIdentity = mapParameterFactory.createSubscriberIdentity(isdnAddressString);
        txMAPSubscriberIdentityWrapper = new TxMAPSubscriberIdentityWrapper(subscriberIdentity);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPSubscriberIdentityWrapper);
        TxMAPSubscriberIdentityWrapper tx = (TxMAPSubscriberIdentityWrapper) deserializeFromFile();

        assertTrue(txMAPSubscriberIdentityWrapper.getTxMAPSubscriberIdentity().getMSISDN().getAddressNature()
                .getIndicator() == tx.getTxMAPSubscriberIdentity().getMSISDN().getAddressNature().getIndicator());
        assertTrue(txMAPSubscriberIdentityWrapper.getTxMAPSubscriberIdentity().getMSISDN().getAddress()
                .equals(tx.getTxMAPSubscriberIdentity().getMSISDN().getAddress()));

    }

}
