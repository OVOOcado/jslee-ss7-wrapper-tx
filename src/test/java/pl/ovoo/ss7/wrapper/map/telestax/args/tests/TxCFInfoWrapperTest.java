package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.CFStatusWrapper;
import pl.ovoo.ss7.wrapper.map.args.ForwardedToNumberWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCFInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCFStatusWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxForwardedToNumberWrapper;

public class TxCFInfoWrapperTest extends WrapperBaseTest {

    TxCFInfoWrapper txCFInfoWrapper;

    @Before
    public void setUp() throws Exception {

        SubscriberCfStatus subscriberCfStatus = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.QUIESCENT, CfStatusActivationIndicator.NOT_ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);
        AddressString addressString = mapParameterFactory.createAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "0048372612952");
        ForwardedToNumberWrapper forwardedToNumberWrapper = new TxForwardedToNumberWrapper(addressString);
        CFStatusWrapper cfStatusWrapper = new TxCFStatusWrapper(subscriberCfStatus);

        txCFInfoWrapper = new TxCFInfoWrapper(cfStatusWrapper, forwardedToNumberWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txCFInfoWrapper);
        TxCFInfoWrapper tx = (TxCFInfoWrapper) deserializeFromFile();

        assertTrue(txCFInfoWrapper.getCFStatus().getProvided() == tx.getCFStatus().getProvided());
        assertTrue(txCFInfoWrapper.getCFStatus().getQuiescent() == tx.getCFStatus().getQuiescent());
        assertTrue(txCFInfoWrapper.getCFStatus().getActive() == tx.getCFStatus().getActive());
        assertTrue(txCFInfoWrapper.getCFStatus().getRegistered() == tx.getCFStatus().getRegistered());

        assertTrue(txCFInfoWrapper.getForwardedToNumber().getAddress().equals(tx.getForwardedToNumber().getAddress()));
        assertTrue(txCFInfoWrapper.getForwardedToNumber().getNature().getValue() == tx.getForwardedToNumber()
                .getNature().getValue());
        assertTrue(txCFInfoWrapper.getForwardedToNumber().getNumberingPlan().getValue() == tx.getForwardedToNumber()
                .getNumberingPlan().getValue());

    }

}
