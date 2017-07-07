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

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.InformationToSend;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.Tone;
import org.mobicents.protocols.ss7.cap.service.circuitSwitchedCall.primitive.ToneImpl;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxInformationToSendWrapper;

public class TxInformationToSendWrapperTest extends WrapperBaseTest {

    TxInformationToSendWrapper txInformationToSendWrapper;

    @Before
    public void setUp() throws Exception {

        Tone tone = capFactory.createTone(ToneImpl._ID_toneID, ToneImpl._ID_duration);
        InformationToSend informationToSend = capFactory.createInformationToSend(tone);
        txInformationToSendWrapper = new TxInformationToSendWrapper(informationToSend);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txInformationToSendWrapper);
        TxInformationToSendWrapper tx = (TxInformationToSendWrapper) deserializeFromFile();

        assertTrue(txInformationToSendWrapper.getTxInformationToSend().getTone().getDuration().intValue() == tx
                .getTxInformationToSend().getTone().getDuration().intValue());
        assertTrue(txInformationToSendWrapper.getTxInformationToSend().getTone().getToneID() == tx
                .getTxInformationToSend().getTone().getToneID());
    }

}
