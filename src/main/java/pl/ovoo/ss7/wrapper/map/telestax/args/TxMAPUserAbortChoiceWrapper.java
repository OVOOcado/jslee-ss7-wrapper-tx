/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import pl.ovoo.ss7.wrapper.map.args.MAPUserAbortChoiceWrapper;

/**
 * TxMAPSubscriberIdentityWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxMAPUserAbortChoiceWrapper implements MAPUserAbortChoiceWrapper {

    private final MAPUserAbortChoice choice;

    public TxMAPUserAbortChoiceWrapper(final MAPUserAbortChoice choice) {
        this.choice = choice;
    }

    public MAPUserAbortChoice getTxMAPUserAbortChoice() {
        return choice;
    }

    @Override
    public String toString() {
        return "TxMAPUserAbortChoiceWrapper [choice=" + choice + "]";
    }

}
