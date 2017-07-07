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

package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import org.mobicents.protocols.ss7.map.api.dialog.ProcedureCancellationReason;
import org.mobicents.protocols.ss7.map.api.dialog.ResourceUnavailableReason;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPUserAbortChoiceWrapper;

public class TxMAPUserAbortChoiceWrapperTest extends WrapperBaseTest {

    TxMAPUserAbortChoiceWrapper txMAPUserAbortChoiceWrapper;

    @Before
    public void setUp() throws Exception {

        MAPUserAbortChoice mapUserAbortChoice = mapParameterFactory.createMAPUserAbortChoice();
        mapUserAbortChoice.setProcedureCancellationReason(ProcedureCancellationReason.callRelease);
        mapUserAbortChoice.setResourceUnavailableReason(ResourceUnavailableReason.longTermResourceLimitation);
        mapUserAbortChoice.setUserResourceLimitation();
        mapUserAbortChoice.setUserSpecificReason();

        txMAPUserAbortChoiceWrapper = new TxMAPUserAbortChoiceWrapper(mapUserAbortChoice);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPUserAbortChoiceWrapper);
        TxMAPUserAbortChoiceWrapper tx = (TxMAPUserAbortChoiceWrapper) deserializeFromFile();

        assertTrue(txMAPUserAbortChoiceWrapper.getTxMAPUserAbortChoice().getProcedureCancellationReason()
                .getCode() == tx.getTxMAPUserAbortChoice().getProcedureCancellationReason().getCode());
        assertTrue(txMAPUserAbortChoiceWrapper.getTxMAPUserAbortChoice().getResourceUnavailableReason().getCode() == tx
                .getTxMAPUserAbortChoice().getResourceUnavailableReason().getCode());

    }

}
