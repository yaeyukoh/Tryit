<<<<<<< HEAD
LPMT - Little Projection-Mapping Tool
---------------------------------------
(C) 2011, HVA - Hermanitos Verdes Architetti / Modena, Italy

[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=hv_francesco&url=https://github.com/hvfrancesco/lpmt&title=LPMT Little Projection-Mapping Tool&language=&tags=github&category=software)


LPMT is a little projection-mapping tool for use in our office,
it is developed in C++ using OpenFrameworks.
It’s based on simple quad warping paradigm, and, though rather simple, can
be used to achieve complex and professional projection-mapping sets.

This is the up-to-date version of lpmt, based on OpenFrameworks 007

DOWNLOAD:
----------

At the moment LPMT is only available as source code, and we've only tested it on linux systems
but thanks to the multi-platform nature of OpenFrameworks it should work out-of-the-box on
Windows and OsX too.

up-to-date code (git repository):
http://gitorious.org/projection-mapping

for the github fans, the repository is mirrored here:
https://github.com/hvfrancesco/ProjectionMapping

if you don't like git, you can find a rarely updated zip file:
http://www.hv-a.com/projectTiles/projection-mapping.zip



MAIN FEATURES:
--------------

* up to 36 independent projection surfaces (remember you can use a solid black quad even as a mask)
* possible content: solid color, images, video, live-cam, slideshows, smoothly changing solid colors, and more …
* customizable green-screen (chromakey) for video and live-cam sources
* horizontal and vertical flipping for image, video and live-cam content
* independent opacity settings for each content element
* customizable colorization for each content element
* several blending-modes for projection surfaces
* on-screen editable masks
* bezier-warping for projection on curved surfaces
* grid-warping, with user defined grid density
* spherize deformation preset
* realtime live-masking with Kinect
* customizable video speed and volume
* save/load project set to/from xml file
* syncronized start for video elements
* vertex snap function for adjacent quads
* cam snapshot background for rough positioning of projection surfaces
* customizable speed for slideshows and color transitions
* synced multi-projectors shows with adjustable edge-blending
* control and setup through a rich set of OSC messages
* a powerful timeline to trigger events and control LPMT projections



KEY COMMANDS:
-------------

’s' – saves settings to xml (projection_settings.xml in data folder)
‘l’ – loads settings from xml file

‘a’ – adds new quad
‘>’ – go to next quad
‘<’ – go to previous quad
'+' - raise active quad position in layers pile
'-' - lower active quad position in layers pile
‘z’ – selects first gui page for active quad settings
‘x’ – selects second gui page for active quad settings
‘c’ – selects gui page for active quad corner position fine-tuning
‘q’ – fills window with active quad
‘1’ – shows general settings page of gui

‘g’ – toggles gui (for quad warping with mouse gui must be switched off)
‘f’ – toggles fullscreen mode
‘w’ – toggles cam snapshot window background
‘m’ – toggles mask-editing mode
‘b’ – toggles surface bezier/grid warping editing mode

‘spacebar’ – toggles projection/setup modes
‘r’ – resyncs all videos and slideshows in all quads to starting point
‘p’ – starts projection
‘o’ – stops projection

‘n’ – connects to a MostPixelsEver sync server

‘F10’ – toggles timeline interface
‘F9’ – toggles timeline BPM reference grid
‘F11’ – toggles stage visibility under timeline
‘F12’ – play/stop timeline



TODO:
----------

- midi control
- DMX control
- timeline sync with MTC midi


CONTACT:
----------

you can contact us at:
francesco[at]hv-a.com

-------------------------------------------------------------------------------

this README was last edited by hv_francesco on Wed Feb 23, 2011 19:54 GMT+1,
edited 1 times in total.

__________________________________

HVA - hermanitos verdes architetti
modena - italy
www.hv-a.com
=======
# Most Pixels Ever

Most Pixels Ever is an open-source framework for spanning graphics applications across multiple screens.

![Screenshot](http://farm3.static.flickr.com/2199/2124879919_6a8e447903_m.jpg)  ![Screenshot](http://farm3.static.flickr.com/2201/2125653100_1954bd6189_m.jpg)  ![Screenshot](http://farm3.static.flickr.com/2190/2124878313_c302b6aac7_m.jpg)

# Getting Started:

Check out the tutorials on the wiki!

[https://github.com/shiffman/Most-Pixels-Ever/wiki](https://github.com/shiffman/Most-Pixels-Ever/wiki)

# Supported environments

* [Processing]()
* [openFrameworks](https://github.com/obviousjim/ofxMostPixelsEver)
* [Cinder](https://github.com/wdlindmeier/Most-Pixels-Ever-Cinder)

# Most Pixels Ever 2.0 Protocol

## Client


| Message           | Example                 |  Description           |
| ----------------- | ----------------------- |  --------------------  | 
| S&#124;#&#124;string               | S&#124;0&#124;render0                    |  Synchronous Client connecting &#124; ID # &#124;  name| 
| A&#124;#&#124;string&#124;boolean  | A&#124;5&#124;render0&#124;true           |  ASychronous Client connecting &#124; ID # &#124; name &#124; messages back yes or no?|
| D&#124;#&#124;#        | D&#124;0&#124;231            |  Client done rendering, ID, frame number |
| T&#124;String          | T&#124;rain,82               |  Data message sent to all client |
| T&#124;String&#124;#,#      | T&#124;rain,82&#124;0,1           |  Data message &#124; which clients to send to |
| P                 | P                       |  Toggle pause state |

## Server

| Message           | Example                 |  Description           |
| ----------------- | ----------------------- |  --------------------  | 
| G&#124;#               | G&#124;231                   |  Go and draw frame 231 | 
| G&#124;#&#124;#,String&#124;#,String | G&#124;231&#124;rain,0,82&#124;3,snow,42   |  Go and draw frame 231 with these messages, messages are preceded by client ID that sent them | 
| R                 | R                       |  Reset to frame 0 |
| P                 | P                       |  Toggle pause state |

 


>>>>>>> f025e648e0804ff834bec5ba6cd6da59e418ca7e
