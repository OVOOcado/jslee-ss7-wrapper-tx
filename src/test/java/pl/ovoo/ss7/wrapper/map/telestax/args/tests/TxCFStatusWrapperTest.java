package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusActivationIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusProvisionIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusQuiescentIndicator;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.SubscriberCfStatus.CfStatusRegisterIndicator;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCFStatusWrapper;

public class TxCFStatusWrapperTest extends WrapperBaseTest {

    TxCFStatusWrapper txCFStatusWrapper;

    @Before
    public void setUp() throws Exception {

        SubscriberCfStatus subscriberCfStatus = mapParameterFactory.createSubscriberCfStatus(
                CfStatusQuiescentIndicator.NOT_QUIESCENT, CfStatusActivationIndicator.ACTIVE,
                CfStatusRegisterIndicator.NOT_REGISTERED, CfStatusProvisionIndicator.NOT_PROVIDED);

        txCFStatusWrapper = new TxCFStatusWrapper(subscriberCfStatus);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txCFStatusWrapper);
        TxCFStatusWrapper tx = (TxCFStatusWrapper) deserializeFromFile();

        assertTrue(txCFStatusWrapper.getActive() == tx.getActive());
        assertTrue(txCFStatusWrapper.getProvided() == tx.getProvided());
        assertTrue(txCFStatusWrapper.getQuiescent() == tx.getQuiescent());
        assertTrue(txCFStatusWrapper.getRegistered() == tx.getRegistered());

        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusActivationIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusActivationIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusProvisionIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusProvisionIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusRegisterIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusRegisterIndicator()));
        assertTrue(txCFStatusWrapper.getTxSubscriberCfStatus().getCfStatusQuiescentIndicator()
                .equals(tx.getTxSubscriberCfStatus().getCfStatusQuiescentIndicator()));

    }

}
