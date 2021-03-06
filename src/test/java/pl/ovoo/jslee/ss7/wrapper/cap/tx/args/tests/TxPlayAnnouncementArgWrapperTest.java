/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InbandInfo;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageIDText;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxPlayAnnouncementArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InformationToSendWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInformationToSendWrapper;


/**
 * The Class TxPlayAnnouncementArgWrapperTest.
 */
public class TxPlayAnnouncementArgWrapperTest extends WrapperBaseTest {

    /** The tx play announcement arg wrapper. */
    TxPlayAnnouncementArgWrapper txPlayAnnouncementArgWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        txPlayAnnouncementArgWrapper = new TxPlayAnnouncementArgWrapper();

        final MessageIDText messageIDText = capFactory.createMessageIDText("message", new byte[] { 32 });
        final MessageID messageID = capFactory.createMessageID(messageIDText);
        final InbandInfo inbandInfo = capFactory.createInbandInfo(messageID, 1, 2, 3);
        final InformationToSend informationToSend = capFactory.createInformationToSend(inbandInfo);
        InformationToSendWrapper informationToSendWrapper = new TxInformationToSendWrapper(informationToSend);
        txPlayAnnouncementArgWrapper.setInformationToSend(informationToSendWrapper);

        txPlayAnnouncementArgWrapper.setRequestAnnouncementComplete(new Boolean(true));
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txPlayAnnouncementArgWrapper);
        TxPlayAnnouncementArgWrapper tx = (TxPlayAnnouncementArgWrapper) deserializeFromFile();

        assertTrue(txPlayAnnouncementArgWrapper.getTxInformationToSend().getInbandInfo().getMessageID().getText()
                .getMessageContent()
                .equals(tx.getTxInformationToSend().getInbandInfo().getMessageID().getText().getMessageContent()));
        assertTrue(tx.getTxRequestAnnouncementComplete().booleanValue());

    }

}
