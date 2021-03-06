/*
    Copyright (c) 2008, Interactive Pulp, LLC
    All rights reserved.
    
    Redistribution and use in source and binary forms, with or without 
    modification, are permitted provided that the following conditions are met:

        * Redistributions of source code must retain the above copyright 
          notice, this list of conditions and the following disclaimer.
        * Redistributions in binary form must reproduce the above copyright 
          notice, this list of conditions and the following disclaimer in the 
          documentation and/or other materials provided with the distribution.
        * Neither the name of Interactive Pulp, LLC nor the names of its 
          contributors may be used to endorse or promote products derived from 
          this software without specific prior written permission.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
    POSSIBILITY OF SUCH DAMAGE.
*/

package pulpcore.animation.event;

import pulpcore.sprite.Group;
import pulpcore.sprite.Sprite;

/**
    A RemoveSpriteEvent is a {@link TimelineEvent} that removes a Sprite from a Group after a 
    specified delay.
*/
public class RemoveSpriteEvent extends TimelineEvent {


    private final Group group;
    private final Sprite sprite;

    /**
        Removes the specified sprite from its parent after the delay. The parent is determined
        at the time the event runs. If the sprite does not have a parent at the time the event
        runs, this event does nothing.
    */
    public RemoveSpriteEvent(Sprite sprite, int delay) {
        super(delay);
        this.group = null;
        this.sprite = sprite;
    }

    /**
        Removes the specified sprite from the specified group after the delay. If the sprite
        does not belong to the Group at the time the event runs, this event does nothing.
    */
    public RemoveSpriteEvent(Group group, Sprite sprite, int delay) {
        super(delay);
        this.group = group;
        this.sprite = sprite;
    }
    
    public void run() {
        if (group == null) {
            sprite.removeFromParent();
        }
        else {
            group.remove(sprite);
        }
    }
}