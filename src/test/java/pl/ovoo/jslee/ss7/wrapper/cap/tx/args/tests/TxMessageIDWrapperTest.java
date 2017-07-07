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
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.MessageIDText;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxMessageIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxMessageIDWrapperTest extends WrapperBaseTest {

    TxMessageIDWrapper txMessageIDWrapper;

    @Before
    public void setUp() throws Exception {

        MessageIDText messageIDText = capFactory.createMessageIDText("message", new byte[] { 32 });
        MessageID messageID = capFactory.createMessageID(messageIDText);
        txMessageIDWrapper = new TxMessageIDWrapper(messageID);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMessageIDWrapper);
        TxMessageIDWrapper tx = (TxMessageIDWrapper) deserializeFromFile();

        assertTrue(txMessageIDWrapper.getTxMessageID().getText().getMessageContent()
                .equals(tx.getTxMessageID().getText().getMessageContent()));
        assertTrue(txMessageIDWrapper.getTxMessageID().getText().getAttributes()[0] == tx.getTxMessageID().getText()
                .getAttributes()[0]);
    }

}
